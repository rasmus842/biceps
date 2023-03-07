/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ee.biceps.generated.api;

import ee.biceps.generated.model.ErrorMessage;
import ee.biceps.generated.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
public interface ProductsApi {

    default ProductsApiDelegate getDelegate() {
        return new ProductsApiDelegate() {};
    }

    /**
     * POST /products : Insert a new product.
     * Creates a new product object and save it into database.
     *
     * @param productDTO Information about new product. (optional)
     * @return Returned a new product object with fullfilled id field from database. (status code 201)
     *         or Invalid request body content. (status code 400)
     */
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/products",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ProductDTO> addProduct(
         @Valid @RequestBody(required = false) ProductDTO productDTO
    ) {
        return getDelegate().addProduct(productDTO);
    }


    /**
     * GET /products : Query a list of products.
     * Collects all the products in databases and returns them as a list.
     *
     * @param maxResults The numbers of items to return. (optional, default to 20)
     * @return Returned a list of products. (status code 200)
     */
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/products",
        produces = { "application/json" }
    )
    default ResponseEntity<List<ProductDTO>> getProducts(
        @Min(1) @Max(50)  @Valid @RequestParam(value = "maxResults", required = false, defaultValue = "20") Integer maxResults
    ) {
        return getDelegate().getProducts(maxResults);
    }


    /**
     * DELETE /products/{productId} : Deletes a product.
     * Searches for a specific product with given id and deletes it from database.
     *
     * @param productId Common ID parameter of product. (required)
     * @return Bus with given ID deleted successfully. (status code 204)
     *         or Bus with given ID not found error. (status code 404)
     */
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/products/{productId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> removeProduct(
         @PathVariable("productId") Integer productId
    ) {
        return getDelegate().removeProduct(productId);
    }


    /**
     * PUT /products/{productId} : Updates product information.
     * Searches for a specific product with given id and updates its data.
     *
     * @param productId Common ID parameter of product. (required)
     * @param productDTO Information about product. (required)
     * @return Returned a updated product object. (status code 200)
     *         or Product with given ID not found error. (status code 404)
     *         or Invalid request body content. (status code 400)
     */
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/products/{productId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ProductDTO> updateProduct(
         @PathVariable("productId") Integer productId,
         @Valid @RequestBody ProductDTO productDTO
    ) {
        return getDelegate().updateProduct(productId, productDTO);
    }

}
