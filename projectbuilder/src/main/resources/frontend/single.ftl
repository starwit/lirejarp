<div id="templatemo_content">
	<h1>{{title | translate}}</h1>
	<div class="content_wrapper content_mb_60">
		<div id="contact_form">
			<div class="error">
				<b>{{message}}</b>
				<ul>
					<li ng-repeat="error in validationErrors">{{error.fieldname}}: {{error.message}}</li>
				</ul>
			</div>
			<div class="clear"></div>
			<#list (attributes) as attribute> 
			<#if attribute.dataType == "String"> 
			
			<label for="${attribute.columnName?lower_case}">{{'${domain?uncap_first}.${attribute.columnName}' | translate}}:</label>
			<input name="${attribute.columnName?lower_case}" id="${attribute.columnName?lower_case}" type="text" ng-model="${domain?lower_case}.${attribute.columnName?uncap_first}" />
			</#if>
			<#if attribute.dataType == "Integer"> 
			<label for="${attribute.columnName?lower_case}">{{'${domain?uncap_first}.${attribute.columnName}' | translate}}:</label>
			<input name="${attribute.columnName?lower_case}" id="${attribute.columnName?lower_case}" type="text" ng-model="${domain?lower_case}.${attribute.columnName?uncap_first}" numberinput='' ng-pattern="/^\d{1,4}(\.\d{0,4})?$/"
			/>
			</#if>
			<#if attribute.dataType == "BigDecimal"> 
			<label for="${attribute.columnName?lower_case}">{{'${domain?uncap_first}.${attribute.columnName}' | translate}}:</label>
			<input name="${attribute.columnName?lower_case}" id="${attribute.columnName?lower_case}" type="text" placeholder="_,_" ng-model="${domain?lower_case}.${attribute.columnName?uncap_first}" numberinput='' ng-pattern="/^\d{1,4}(\.\d{0,4})?$/"
			/>
			</#if>
			<#if attribute.dataType == "Double"> 
			<label for="${attribute.columnName?lower_case}">{{'${domain?uncap_first}.${attribute.columnName}' | translate}}:</label>
			<input name="${attribute.columnName?lower_case}" id="${attribute.columnName?lower_case}" type="text" placeholder="_,_" ng-model="${domain?lower_case}.${attribute.columnName?uncap_first}" numberinput='' ng-pattern="/^\d{1,4}(\.\d{0,4})?$/"
			/>
			</#if>
			</#list>
			<button class="submit_btn left" ng-click="doMaintain()">Save</button>
			<button class="submit_btn left" ng-click="doBack()">Cancel</button>
		</div>
	</div>
</div>