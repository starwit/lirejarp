<div id="templatemo_content">
	<h1>{{title | translate}}</h1>
	<div class="content_wrapper content_mb_60">
	<div id="menuWrap">
		<button ng-click="gotoCreate${domain}();">create</button>
		<button ng-click="idSelected != null && gotoUpdate${domain}(idSelected);" ng-disabled="idSelected == null">update</button>
		<button ng-click="idSelected != null && delete${domain}(idSelected);" ng-disabled="idSelected == null">delete</button>
	</div>
		<table>
		<thead>
			<#list attributes> 
			<tr>
				<#items as attribute>
				<th>{{'${domain?uncap_first}.${attribute.columnName}' | translate}}</th>
				</#items>
			</tr>	
			</#list>
		</thead>
		<tbody>
			<tr ng-repeat="${domain?lower_case} in ${domain?lower_case}All" ng-click="setSelected(${domain?lower_case}.id)" 
				ng-class="{selected: ${domain?lower_case}.id === idSelected }" 
				ng-dblclick="setSelected(${domain?lower_case}.id);gotoUpdate${domain}(idSelected);">

				<#list attributes> 
				<#items as attribute>
				<td>{{${domain?lower_case}.${attribute.columnName}}}</td>
				</#items>
				</#list>
			</tr>
		</tbody>
		<tfoot></tfoot>
		</table>
	</div>
</div>