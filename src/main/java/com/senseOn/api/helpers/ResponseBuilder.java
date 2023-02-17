package com.senseOn.api.helpers;
import java.util.HashMap;
import java.util.Map;


public class ResponseBuilder {

    private Response response;
    private Map<Integer, Furniture> furnitures;

    public ResponseBuilder() {
        furnitures = new HashMap<>();
        addFurnitures();
    }

    public Response buildPostResponse(String data) {
        int id = validateStringAndReturnId(data);

        // id == -1 if validation failed
        if (id == -1) {
            return new Response(400, "Scanned Qr code is not of correct format", null);
        }

        return null;
    }

    public Response buildGetResponse(String data) {

        int id = validateStringAndReturnId(data);

        // id == -1 if validation failed
        if (id == -1) {
            return new Response(400, "Scanned Qr code is not of correct format", null);
        }

        Furniture furniture = furnitures.get(id);

        if(furniture != null) {
            return new Response(200, "Furniture with id " + id + " found!", furniture);
        }else return new Response(404, "Furniture with id " + id + " not found!", null);
    }

    // validates input by checking that it consists of a valid id and the word "senseon"
    private int validateStringAndReturnId(String data) {
        String[] dataSplit = data.split("-");
        String validationCode = dataSplit[0];

        // Checks if string contains code and id
        if(dataSplit.length < 2)
            return -1;

        int furnitureId = Integer.parseInt(dataSplit[1]);

        if (!validationCode.contains("senseon")) {
            return -1;
        }

        return furnitureId;
    }

    private void addFurnitures() {
        for(int i = 1; i <= 10; i++) {
            String furnitureName = "Furniture " + i;
            int quantity = i * 10;
            furnitures.put(i, new Furniture(furnitureName, quantity));
        }
    }
}
