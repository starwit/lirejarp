package de.starwit.lirejarp.api.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.starwit.lirejarp.api.rest.response.Response;
import de.starwit.lirejarp.ejb.DataImportExportService;

@Path("/importexport")
@Consumes("application/json")
@Produces("application/json")
public class DataImportExportRest {
	
	@Inject
	DataImportExportService service;

	@Path("/importall")
	@GET
	public Response<Void> importAll() {
		service.importAll();
		return new Response<>();
	}
}
