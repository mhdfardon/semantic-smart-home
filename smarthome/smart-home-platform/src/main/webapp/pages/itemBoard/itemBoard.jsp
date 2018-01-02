<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/sideline/header/head.jsp" />
<link href="/home/sideline/style/itemBoard.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='/home/pages/itemBoard/js/itemBoard.js'></script>
<title>Tableau de bord des articles</title>
</head>
<body>
	<jsp:include page="/sideline/header/globalFrame.jsp" />
	<h2>D&eacute;tails des achats</h2>
	<jsp:include page="/sideline/header/menu.jsp" />

	<div id="mainContent">
	
		<div id="searchCriteriaDiv" 
			itemStartDate = "<s:property value="itemStartDate"/>"
			itemEndDate = "<s:property value="itemEndDate"/>"
			categoriesIdsString = "<s:property value="categoriesIdsString"/>"
			userId = "<s:property value="userId"/>">
		</div>

		<div id="itemsTableDiv">
			<s:if test="itemList.size() > 0">
				<table id="itemsListTable">
					<thead>
					<tr>
						<th class="itemName">Nom de l'achat</th>
						<th class="itemDescription">Description</th>
						<th class="itemDate">Date d'achat</th>
						<th class="itemCategory">Cat&eacute;gorie</th>
						<th class="itemPrice">Prix</th>
						<th class="itemRealPrice">Prix r&eacute;el</th>
						<th class="itemRestaurantTickets">Nombre de tickets restaurants</th>
						<th class="itemTicketsAmount">Montant des tickets</th>
						<th class="itemUser">Achat effectu&eacute; par</th>
					</tr>
					</thead>
					<tbody>
					<s:iterator value="itemList">
						<tr class="cat<s:property value="category.id"/>">
							<td class="itemName">
								<div class="left">
									<s:property value="name"/>
								</div>
								<div itemId="<s:property value="id" />"
									title="Modifier les d&eacute;tails de l'achat"
									class="restTest">
<!-- 									class="itemConfigure"> -->
								</div>
							</td>
							<td class="itemDescription"><s:property value="description"/></td>
							<td class="itemDate"><s:date name="date" format="dd/MM/yyyy" /></td>
							<td class="itemCategory"><s:property value="category.name"/></td>
							<td class="itemPrice"><s:property value="price" /></td>
							<td class="itemPrice"><s:property value="realPrice" /></td>
							<td class="itemRestaurantTickets"><s:property value="restaurantTickets"/></td>
							<td class="itemTicketsAmount"><s:property value="ticketsAmount"/></td>
							<td class="itemUser"><s:property value="user.name"/></td>
						</tr>
					</s:iterator>
					</tbody>
					<tfoot></tfoot>
				</table>
			</s:if>
			<s:else>
				Pas d'articles choisis
			</s:else>
		</div>
		
		<div id="excelExportDiv">
			<button id="excelExport">Exporter Excel</button>
		</div>

		<div id="showHideDiv">
			<div id="showHideIcon" title="Montrer / cacher les sous-totaux" statut="hide"></div>
		</div>
		
		<div id="totalsTableDiv">
			<s:if test="itemsSubTotalsList.size() > 0">
				<table id="totalsTable">
					<tr>
						<th class="itemName">Nom de l'achat</th>
						<th class="itemDescription">Description</th>
						<th class="itemCategory">Cat&eacute;gorie</th>
						<th class="itemPrice">Prix</th>
						<th class="itemRealPrice">Prix r&eacute;el</th>
						<th class="itemRestaurantTickets">Nombre des tickets restaurants</th>
						<th class="itemTicketsAmount">Montant des tickets</th>
						<th class="itemUser">Achat effectu&eacute; par</th>
					</tr>
					<s:iterator value="itemsSubTotalsList">
						<tr class="cat<s:property value="category.id"/>">
							<td class="itemName"><s:property value="name"/></td>
							<td class="itemDescription"><s:property value="description"/></td>
							<td class="itemCategory"><s:property value="category.name"/></td>
							<td class="itemPrice"><s:property value="getText('format.number', {price})" /></td>
							<td class="itemPrice"><s:property value="getText('format.number', {realPrice})" /></td>
							<td class="itemRestaurantTickets"><s:property value="restaurantTickets"/></td>
							<td class="itemTicketsAmount"><s:property value="ticketsAmount"/></td>
							<td class="itemUser"><s:property value="user.name"/></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
			<s:else>
				Pas d'articles choisis
			</s:else>
		</div>

		<div id="searchDiv">
			<span id="itemSearchDivTitle">Rechercher les articles :</span>
			<div id="criteriaDiv">
				<form name="itemSearchForm" method="get" id="itemSearchForm">
					<table id="criteriaTable">
						<tbody>
							<tr>
								<td>
									<label for="itemStartDate"><b>Date d&eacute;but :</b></label>
								</td>
								<td>
									<input type="text" id="itemStartDate" name="itemStartDate" value="" class="datePicker" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="itemEndDate"><b>Date fin :</b></label> 
								</td>
								<td>
									<input type="text" id="itemEndDate" name="itemEndDate" value="" class="datePicker" readonly="readonly" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="userId"><b>Achat fait par :</b></label>
								</td>
								<td>
									<select id="userId" name="userId">
										<option value="0" selected></option>
										<s:iterator value="userList">
											<option Value="<s:property value="id"/>">
												<s:property value="name"/>
											</option>
										</s:iterator>
									</select>
								</td>
							</tr>
						</tbody>
					</table>

					<label for="itemCategory"><b>Choisir les categories :</b></label>
					<div id="categoriesDiv">
					 	<s:checkboxlist list="categoryList" name="categoriesIdsString" listKey="id" listValue="name" cssStyle="vertical" labelposition="left" />
					</div>
				</form>
				<button id="submit">Lancer la recherche</button>
			</div>
		</div>
		
		<div id="itemDeployDiv">
		</div>
		<form name="itemExcelExport" method="get" id="itemExcelExport">
		</form>
		<form name="itemDetailsForm" method="post" id="itemDetailsForm" action="itemBoardAction.action">
		</form>
	</div>
</body>
</html>