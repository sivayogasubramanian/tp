package ay2122s1_cs2103t_w16_2.btbb.testutil;

import static ay2122s1_cs2103t_w16_2.btbb.logic.parser.util.CliSyntax.PREFIX_CLIENT_ADDRESS;
import static ay2122s1_cs2103t_w16_2.btbb.logic.parser.util.CliSyntax.PREFIX_CLIENT_NAME;
import static ay2122s1_cs2103t_w16_2.btbb.logic.parser.util.CliSyntax.PREFIX_CLIENT_PHONE;

import ay2122s1_cs2103t_w16_2.btbb.logic.commands.order.AddOrderCommand;
import ay2122s1_cs2103t_w16_2.btbb.model.order.Order;

/**
 * A utility class for Order.
 */
public class OrderUtil {
    public static String getAddCommand(Order order) {
        return AddOrderCommand.COMMAND_WORD + " " + getOrderDetails(order);
    }

    public static String getOrderDetails(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_CLIENT_NAME + order.getClientName().toString() + " ");
        sb.append(PREFIX_CLIENT_PHONE + order.getClientPhone().toString() + " ");
        sb.append(PREFIX_CLIENT_ADDRESS + order.getClientAddress().toString() + " ");
        return sb.toString();
    }
}
