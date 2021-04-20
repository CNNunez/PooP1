public class LogicaDeFuncionamiento {
    LogicaDeFuncionamiento(Menu restaurantMenu, ClientList ListOnWating, ClientList ListReadyToOrder, ClientList ListOnPending, ProductionList ListOnProduction, Record restaurantRecord, Ventana ventana){
        
        // verificar si hay clientes listos para hacer su orden
        String info = "";
        ListReadyToOrder = ListOnWating.checkWaitingTime();
        if (ListReadyToOrder.isEmpty()){
            info += "No hay clientes listos para ordenar\n";
        }else{
<<<<<<< HEAD
            info += "-------------------------------------- Ready to Order\n";
=======
            System.out.println("-------------------------------------- Ready to Order");
>>>>>>> bbc4f83f662de33c84c3d97965ecc9a555398f3a
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

<<<<<<< HEAD
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
=======
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
        
>>>>>>> bbc4f83f662de33c84c3d97965ecc9a555398f3a
        
        // actualizar contadores de los clientes
        ListOnWating.updateClientWaiting();
        ListOnPending.updateClientPatience(ListOnProduction, restaurantRecord);
<<<<<<< HEAD
        if (info != "")
            ventana.setTexto(info);
=======
>>>>>>> bbc4f83f662de33c84c3d97965ecc9a555398f3a
    }
}

