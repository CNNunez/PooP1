public class LogicaDeFuncionamiento {
    LogicaDeFuncionamiento(Menu restaurantMenu, ClientList ListOnWating, ClientList ListReadyToOrder, ClientList ListOnPending, ProductionList ListOnProduction, Record restaurantRecord){
        
        // verificar si hay clientes listos para hacer su orden
        ListReadyToOrder = ListOnWating.checkWaitingTime();
        if (ListReadyToOrder.isEmpty()){
            System.out.println("No hay clientes listos para ordenar");
        }else{
            System.out.println("-------------------------------------- Ready to Order");
            ListReadyToOrder.printClientList();

            // Agregar las ordenes de los clientes
            ListReadyToOrder.addOrdersToClients(restaurantMenu);

            // Agregar pedidos y clientes a la lista de pendientes
            ListOnPending.addClientList(ListReadyToOrder);
            ListOnPending.printClientList();
        }

        // verificar si hay espacio en produccion
        if (ListOnPending.isEmpty() == false){
            System.out.println("Hay pedidos pendientes");
            ListOnProduction.addToProduction(restaurantMenu, ListOnPending);
        }else{
            System.out.println("No hay pedidos pendientes");
        }

        // Print listas
        System.out.println("-------------------------------------- ListOnWating");
        ListOnWating.printClientList();

        System.out.println("-------------------------------------- ListOnPending ");
        ListOnPending.printClientList();

        System.out.println("-------------------------------------- ListOnProduction ");
        ListOnProduction.printProductionList();

        System.out.println("-------------------------------------- restaurantRecord ");
        restaurantRecord.printRecord();

        // Actualizar completitud de productos en la lista de produccion
        ListOnProduction.updateCompleteness(ListOnPending);
        ListOnPending.updateCompleteness(ListOnProduction, restaurantRecord);
        
        
        // actualizar contadores de los clientes
        ListOnWating.updateClientWaiting();
        ListOnPending.updateClientPatience(ListOnProduction, restaurantRecord);
    }
}

