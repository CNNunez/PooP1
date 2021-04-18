public class LogicaDeFuncionamiento {
    LogicaDeFuncionamiento(Menu restaurantMenu, ClientList ListOnWating, ClientList ListReadyToOrder, ClientList ListOnPending, ProductionList ListOnProduction){
        
        // verificar si hay clientes listos para hacer su orden
        ListReadyToOrder = ListOnWating.checkWaitingTime();
        if (ListReadyToOrder.isEmpty()){
            System.out.println("No hay clientes listos para ordenar");
        }else{
            System.out.println("Clientes listos para ordenar");
            ListReadyToOrder.printClientList();

            // Agregar las ordenes de los clientes
            ListReadyToOrder.addOrdersToClients(restaurantMenu);
            ListReadyToOrder.printClientList();

            // Agregar pedidos y clientes a la lista de pendientes
            ListOnPending.addClientList(ListReadyToOrder);
            ListOnPending.printClientList();
        }

        // verificar si hay espacio en produccion
        if (ListOnPending.isEmpty() == false){
            System.out.println("Hay pedidos pendientes");
            ListOnProduction.addToProduction(restaurantMenu, ListOnPending);
            ListOnProduction.printProductionList();
            ListOnPending.printClientList();
        }else{
            System.out.println("No hay pedidos pendientes");
        }
        
        // actualizar contadores de los clientes
        ListOnWating.updateClientPatieneAndWaiting();
    }
}
