package com.environment.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.environment.manage.Product;

@Path("/products")
public class ProductResource {

	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;

	ProductService productService;

	public ProductResource() {
		productService = new ProductService();
	}

	public ProductResource(UriInfo uriInfo2, Request request2, String id) {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Product> getProducts() {
		return productService.getProductAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Product> getProductsAsHtml() {
		return productService.getProductAsList();
	}

	// URI: /rest/products/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(productService.getProductsCount());
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createProduct(@FormParam("id") String id,
			@FormParam("productname") String name,
			@FormParam("productcategory") String category,
			@Context HttpServletResponse servletResponse) throws IOException {
		Product product = new Product(id, name, category);
		productService.createProduct(product);
		servletResponse.sendRedirect("./products/");
	}

	@Path("{product}")
	public ProductResource getProduct(@PathParam("product") String id) {
		return new ProductResource(uriInfo, request, id);
	}



}
