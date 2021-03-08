package hotel.Controller;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.Item;
import hotel.OrderDetails;
import hotel.OrderMaster;
import hotel.Constants.GlobalConstants;
import hotel.DAO.CookServices;

public class CookController extends BaseController {

	private static final long serialVersionUID = -4843668254577645314L;
	CookServices cService = new CookServices();

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		doPostAction(action, request, response);

	}

	public void doPostAction(String action, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String contextPath = request.getContextPath() + "/";
			if (action.equals("addCategory")) {
				String name = request.getParameter("cate");
				if (!cService.isAlreadyExists(name)) {
					if (cService.addCategory(name)) {
						GlobalConstants.MESSAGE = String.format(GlobalConstants.MSG_ADD_SUCCESS, name);
					} else {
						GlobalConstants.MESSAGE = String.format(GlobalConstants.ERROR_ADD, name);
					}
				} else {
					GlobalConstants.MESSAGE =String.format(GlobalConstants.ERROR_CAT_ALREADY, name);
				}
				GlobalConstants.JSP_PAGE = contextPath + "AddCategory.jsp";
				response.sendRedirect(GlobalConstants.JSP_PAGE);

			} else if (action.equals("addItem")) {
				Item item = new Item(request.getParameter("name"),
						Integer.parseInt(request.getParameter("categoryId")),
						Integer.parseInt(request.getParameter("quantity")),
						request.getParameter("cost"));

				System.out.println(item);
				if (!cService.isItemAlreadyExists(item.getName())) {
					if (cService.addItem(item)) {
						GlobalConstants.MESSAGE = String.format(GlobalConstants.MSG_ADD_SUCCESS, item.getName());
					} else {
						GlobalConstants.MESSAGE = String.format(GlobalConstants.ERROR_ADD, item.getName());
					}
				} else {
					GlobalConstants.MESSAGE = String.format(GlobalConstants.ERROR_CAT_ALREADY, item.getName());
				}
				GlobalConstants.JSP_PAGE = contextPath + "AddItem.jsp";
				response.sendRedirect(GlobalConstants.JSP_PAGE);
			}
			else if(action.equals("updateOStatus"))
			{
				int orderId = Integer.parseInt(request.getParameter("orderId"));
				String status = request.getParameter("status");
				System.out.println("id = "+orderId+ "  status ="+status);
				if(cService.updateOrderStatus(orderId, status))
				{
					GlobalConstants.MESSAGE = GlobalConstants.MSG_UPDATE_SUCCESS;
				}
				else
				{
					GlobalConstants.MESSAGE = GlobalConstants.ERROR_UPDATE;
				}
				GlobalConstants.JSP_PAGE = contextPath+"ViewOrder.jsp";
				response.sendRedirect(GlobalConstants.JSP_PAGE);
			}
			else if(action.equals("updateItemStatus"))
			{
				int orderId = Integer.parseInt(request.getParameter("orderId"));
				int itemId = Integer.parseInt(request.getParameter("itemId"));
				String status = request.getParameter("status");
				System.out.println("id = "+orderId+ " ItemId = "+itemId+" status ="+status);
				if(cService.updateItemStatus(orderId, itemId, status))
				{
					GlobalConstants.MESSAGE = GlobalConstants.MSG_UPDATE_SUCCESS;
				}
				else
				{
					GlobalConstants.MESSAGE = GlobalConstants.ERROR_UPDATE;
				}
				GlobalConstants.JSP_PAGE = contextPath+"ViewOrder.jsp";
				response.sendRedirect(GlobalConstants.JSP_PAGE);
			}
			else if(action.equals("makeOrder"))
			{
				System.out.println("In Make order");
				String itemId[] = request.getParameterValues("itemId");
				String qnt[] = request.getParameterValues("quantity");
				int categoryId = Integer.parseInt(request.getParameter("categoryId"));
				String orderName = request.getParameter("orderName");
				int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
				String status = request.getParameter("status");
				
				OrderMaster orderMaster = new OrderMaster();
				orderMaster.setOrderName(orderName);
				orderMaster.setOrderStatus(OrderMaster.getOrderStatus(status));
				orderMaster.setCustomerNumber(customerNumber);
				if(itemId != null && qnt != null)
				{
					if(cService.addOrder(orderMaster))
					{
						int orderId = cService.getLastOrderId();
					
						ArrayList<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
						OrderDetails od = new OrderDetails();
						
						for(int i=0;i<itemId.length;i++)
						{
							od.setOrderId(orderId);
							od.setItemId(Integer.parseInt(itemId[i]));
							od.setQuantity(Integer.parseInt(qnt[i]));
							od.setOrderStatus(OrderDetails.getOrderStatus(OrderDetails.OrderStatus.STARTED.name()));
							orderDetails.add(od);

						}
						if(cService.addOrderedItems(orderDetails))
						{
							GlobalConstants.MESSAGE = "Order Placed Successfully";
						}
						else
						{
							GlobalConstants.MESSAGE = " Error in Order Placing";
						}
					}
					else
					{
						GlobalConstants.MESSAGE = "Error in Order placing";
					}
				}
				else
				{
					GlobalConstants.MESSAGE = "Please select valid order";
				}
				
				GlobalConstants.JSP_PAGE = contextPath+"ViewItems.jsp?categoryId="+categoryId;				
				response.sendRedirect(GlobalConstants.JSP_PAGE);
			}
		
} catch (Exception e) {
		System.out.println("Error in CookController - " + e);
	}
	}

}
