window.swaggerSpec={
  "openapi" : "3.0.3",
  "info" : {
    "title" : "biceps-api",
    "version" : "0.0.1",
    "description" : "Api for demo e-commerce site\n",
    "contact" : {
      "name" : "Rasmus Zalite",
      "url" : "https://github.com/rasmus842",
      "email" : "rasmuszalite@gmail.com"
    }
  },
  "servers" : [ {
    "url" : "http://localhost:8080/api/v1",
    "description" : "Local development server"
  } ],
  "externalDocs" : {
    "url" : "https://swagger.io/specification/",
    "description" : "Find more information about OAS3.0 standard."
  },
  "paths" : {
    "/products" : {
      "get" : {
        "operationId" : "getProducts",
        "summary" : "Query a list of products.",
        "description" : "Collects all the products in databases and returns them as a list.",
        "parameters" : [ {
          "$ref" : "#/components/parameters/MaxResultsParam"
        } ],
        "responses" : {
          "200" : {
            "description" : "Returned a list of products.",
            "content" : {
              "application/json" : {
                "schema" : {
                  "type" : "array",
                  "items" : {
                    "$ref" : "#/components/schemas/ProductDTO"
                  }
                }
              }
            }
          }
        }
      },
      "post" : {
        "operationId" : "addProduct",
        "summary" : "Insert a new product.",
        "description" : "Creates a new product object and save it into database.",
        "requestBody" : {
          "description" : "Information about new product.",
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/ProductDTO"
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "Returned a new product object with fullfilled id field from database.",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/ProductDTO"
                }
              }
            }
          },
          "400" : {
            "description" : "Invalid request body content.",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/ErrorMessage"
                }
              }
            }
          }
        }
      }
    },
    "/products/{productId}" : {
      "put" : {
        "operationId" : "updateProduct",
        "summary" : "Updates product information.",
        "description" : "Searches for a specific product with given id and updates its data.",
        "parameters" : [ {
          "$ref" : "#/components/parameters/ProductIdParam"
        } ],
        "requestBody" : {
          "required" : true,
          "description" : "Information about product.",
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/ProductDTO"
              }
            }
          }
        },
        "responses" : {
          "200" : {
            "description" : "Returned a updated product object.",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/ProductDTO"
                }
              }
            }
          },
          "404" : {
            "description" : "Product with given ID not found error.",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/ErrorMessage"
                }
              }
            }
          },
          "400" : {
            "description" : "Invalid request body content.",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/ErrorMessage"
                }
              }
            }
          }
        }
      },
      "delete" : {
        "operationId" : "removeProduct",
        "summary" : "Deletes a product.",
        "description" : "Searches for a specific product with given id and deletes it from database.",
        "parameters" : [ {
          "$ref" : "#/components/parameters/ProductIdParam"
        } ],
        "responses" : {
          "204" : {
            "description" : "Bus with given ID deleted successfully."
          },
          "404" : {
            "description" : "Bus with given ID not found error.",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/ErrorMessage"
                }
              }
            }
          }
        }
      }
    }
  },
  "components" : {
    "parameters" : {
      "MaxResultsParam" : {
        "description" : "The numbers of items to return.",
        "name" : "maxResults",
        "in" : "query",
        "required" : false,
        "schema" : {
          "type" : "integer",
          "minimum" : 1,
          "maximum" : 50,
          "default" : 20
        }
      },
      "ProductIdParam" : {
        "name" : "productId",
        "in" : "path",
        "description" : "Common ID parameter of product.",
        "required" : true,
        "schema" : {
          "type" : "integer"
        }
      }
    },
    "schemas" : {
      "ProductDTO" : {
        "type" : "object",
        "required" : [ "name" ],
        "properties" : {
          "id" : {
            "type" : "integer",
            "format" : "int64",
            "description" : "Id given by database, undefined in request body.",
            "example" : 0
          },
          "name" : {
            "type" : "string",
            "example" : "T-shirt"
          },
          "price" : {
            "type" : "integer",
            "format" : "int32",
            "example" : 1
          },
          "unit" : {
            "type" : "string",
            "example" : "piece"
          },
          "availableAmount" : {
            "type" : "integer",
            "format" : "int32",
            "example" : 5
          }
        }
      },
      "ErrorMessage" : {
        "type" : "object",
        "properties" : {
          "title" : {
            "type" : "string",
            "description" : "A short summary about the error type.",
            "example" : "Service Unavailable"
          },
          "statusCode" : {
            "type" : "integer",
            "format" : "int32",
            "description" : "The HTTP status code generated by the origin server for this occurrence of the problem.",
            "minimum" : 100,
            "maximum" : 600,
            "exclusiveMaximum" : true,
            "example" : 418
          },
          "detail" : {
            "type" : "string",
            "description" : "A human readable explanation specific to this occurrence of the problem.",
            "example" : "Connection to database timed out"
          }
        }
      }
    }
  }
}