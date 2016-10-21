package om.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import om.models.ItemModel;
import om.services.ItemService;
import om.utilities.Logger;

import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;

@Controller
public class ItemController {

   @Autowired
   ItemService itemService;
   
   private static final Logger LOG = Logger.getInstance(ItemController.class);
   
   @RequestMapping(value = "/items", method = RequestMethod.GET)
   @ResponseBody
   @ResponseStatus(HttpStatus.OK)
    public List<ItemModel> getAllItems() {
	  LOG.info("Get all Item requests");
	  List<ItemModel> itemModels = null;
	  itemModels = itemService.getItems();
      return itemModels;
	}
   
   @RequestMapping(value = "/item", method = RequestMethod.POST) 
   @ResponseBody
   @ResponseStatus(HttpStatus.CREATED)
    public ItemModel uploadItem(@RequestBody ItemModel itemModel)throws BadRequestException{
	  return itemService.addItem(itemModel);
	  
   }
   
   
   @RequestMapping(value = "/item/{itemId}", method = RequestMethod.DELETE)
   @ResponseBody
   @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable int itemId){
	  itemService.deleteItem(itemId);	  
   }
   
   
   @RequestMapping(value = "/item/{itemId}", method = RequestMethod.PATCH)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ItemModel updateItem(@PathVariable int itemId, @RequestBody ItemModel itemModel)
    {
		return itemService.updateItem(itemId, itemModel);
	}
   
   
   @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ItemModel getItem(@PathVariable int itemId) throws BadRequestException
   {
		return itemService.getItem(itemId);
	}
	
}
