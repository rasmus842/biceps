package ee.biceps.generated.api;

import ee.biceps.generated.model.ErrorMessage;
import ee.biceps.generated.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link ProductsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface ProductsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /products : Insert a new product.
     * Creates a new product object and save it into database.
     *
     * @param productDTO Information about new product. (optional)
     * @return Returned a new product object with fullfilled id field from database. (status code 201)
     *         or Invalid request body content. (status code 400)
     * @see ProductsApi#addProduct
     */
    default ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unit\" : \"piece\", \"availableAmount\" : 5, \"price\" : 1, \"name\" : \"T-shirt\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /products : Query a list of products.
     * Collects all the products in databases and returns them as a list.
     *
     * @param maxResults The numbers of items to return. (optional, default to 20)
     * @return Returned a list of products. (status code 200)
     * @see ProductsApi#getProducts
     */
    default ResponseEntity<List<ProductDTO>> getProducts(Integer maxResults) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unit\" : \"piece\", \"availableAmount\" : 5, \"price\" : 1, \"name\" : \"T-shirt\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /products/{productId} : Deletes a product.
     * Searches for a specific product with given id and deletes it from database.
     *
     * @param productId Common ID parameter of product. (required)
     * @return Bus with given ID deleted successfully. (status code 204)
     *         or Bus with given ID not found error. (status code 404)
     * @see ProductsApi#removeProduct
     */
    default ResponseEntity<Void> removeProduct(Integer productId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

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
     * @see ProductsApi#updateProduct
     */
    default ResponseEntity<ProductDTO> updateProduct(Integer productId,
        ProductDTO productDTO) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"unit\" : \"piece\", \"availableAmount\" : 5, \"price\" : 1, \"name\" : \"T-shirt\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
