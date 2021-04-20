public class LogicaDeFuncionamiento {
    LogicaDeFuncionamiento(Menu restaurantMenu, ClientList ListOnWating, ClientList ListReadyToOrder, ClientList ListOnPending, ProductionList ListOnProduction, Record restaurantRecord, Ventana ventana){
        
        // verificar si hay clientes listos para hacer su orden
        String info = "";
        ListReadyToOrder = ListOnWating.checkWaitingTime();
        if (ListReadyToOrder.isEmpty()){
            info += "No hay clientes listos para ordenar\n";
        }else{
            info += "-------------------------------------- Ready to Order\n";
            ListReadyToOrder.printClientList();

            // Agregar las ordenes de los clientes
            ListReadyToOrder.addOrdersToClients(restaurantMenu);

            // Agregar pedidos y clientes a la lista de pendientes
            ListOnPending.addClientList(ListReadyToOrder);
            ListOnPending.printClientList();
        }

        // verificar si hay espacio en produccion
        if (ListOnPending.isEmpty() == false){
            info += "Hay pedidos pendientes\n";
            ListOnProduction.addToProduction(restaurantMenu, ListOnPending);
        }else{
            info +="No hay pedidos pendientes\n";
        }

        info += "-------------------------------------- ListOnWating\n";
        ListOnWating.printClientList();

        info += "-------------------------------------- ListOnPending\n";
        ListOnPending.printClientList();

        info += "-------------------------------------- ListOnProduction\n";
        ListOnProduction.printProductionList();

        info += "-------------------------------------- restaurantRecord\n";
        restaurantRecord.printRecord();
        // Actualizar completitud de productos en la lista de produccion
        ListOnProduction.updateCompleteness(ListOnPending);
        ListOnPending.updateCompleteness(ListOnProduction, restaurantRecord);
        
        // actualizar contadores de los clientes
        ListOnWating.updateClientWaiting();
        ListOnPending.updateClientPatience(ListOnProduction, restaurantRecord);
        if (info != "")
            ventana.setTexto(info);
    }
}

