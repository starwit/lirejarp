<div id="templatemo_sidebar">
	<div class="sidebar_content_box">
	</div>
</div>

<div id="templatemo_content">
	<h1>{{title}}</h1>
	<div class="content_wrapper content_mb_60">
		<div id="contact_form">
			<div class="error">
				<b>{{message}}</b>
				<ul>
					<li ng-repeat="error in validationErrors">{{error.fieldname}}: {{error.message}}</li>
				</ul>
			</div>
			<div class="clear"></div>
			
			<button class="submit_btn left" ng-click="doMaintain()">Save</button>
		</div>

	</div>
</div>