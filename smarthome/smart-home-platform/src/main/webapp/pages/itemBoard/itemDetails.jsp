<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul>
	<li>
		<label for="itemName"><b>Nom de l'achat 
		:</b></label> <input type="text" name="itemName" 
		id="itemName" value="<s:property value="loadedItem.name" />"  />
	</li>
	<li>
		<label for="itemDescription"><b>Description 
		:</b></label><br> 
			<s:textarea name="itemDescription" cols="40" rows="3" value="%{loadedItem.description}" >
			</s:textarea>
	</li>
				
	<li><label for="itemDate"><b>Date et heure de l'achat 
		:</b></label> <input type="text" name="itemDate"
		id="itemDate" class="datePicker" readonly="readonly"
		value="<s:date name="loadedItem.date" format="dd/MM/yyyy" />" />
	</li>
	
	<li>
		<label for="itemPrice"><b>Prix de l'achat 
		:</b></label> <input type="text" name="itemPrice" 
		id="itemPrice" value="<s:property value="loadedItem.price" />"  />
	</li>
	
	<li>
		<label for="itemRealPrice"><b>Prix r&eacute;el de l'achat 
		:</b></label> <s:property value="loadedItem.realPrice" />
	</li>
	
	<li>
		<label for="ticketsNb"><b>Nombre de tickets restaurant
		:</b></label> <input type="text" name="ticketsNb" 
		id="ticketsNb" value="<s:property value="loadedItem.restaurantTickets" />"  />
	</li>
	
	<li>
		<label for="ticketsAmount"><b>Montant des tickets 
		:</b></label> <input type="text" name="ticketsAmount" 
		id="ticketsAmount" value="<s:property value="loadedItem.ticketsAmount" />"  />
	</li>
	
	<li>
		<label for="itemCategory"><b>Cat&eacute;gorie de l'achat :</b></label> 
		<select id="itemCategory" name="itemCategory">
			<s:iterator value="categoryList">
				<s:if test="id == loadedItem.category.id">
					<option Value="<s:property value="id"/>" selected>
						<s:property value="name" />
					</option>
				</s:if>
				<s:else>
					<option Value="<s:property value="id"/>">
						<s:property value="name" />
					</option>
				</s:else>
			</s:iterator>
		</select>
	</li>
	
	<li>
		<label for="itemUser"><b>Achat fait par :</b></label>
		<select id="itemUser" name="itemUser">
			<option value="noUser" selected>
				&nbsp;
			</option>
			<s:iterator value="userList">
				<s:if test="id == loadedItem.user.id">
					<option Value="<s:property value="id"/>" selected>
						<s:property value="name" />
					</option>
				</s:if>
				<s:else>
					<option Value="<s:property value="id"/>">
						<s:property value="name" />
					</option>
				</s:else>
			</s:iterator>
		</select>
	</li>
				
</ul>
