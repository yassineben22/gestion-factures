# gestion_factures_main API

This API provides functionality for managing invoices (`factures`), expenses (`depenses`), categories, and user authentication using jwt token and refresh token.


## Endpoints

### Factures

#### GET `/api/factures`

Retrieve all factures.

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: Array of `FactureDto`

#### POST `/api/factures`

Create a new facture.

- **Request Body:**
    - Content Type: `application/json`
    - Schema: `FactureAdd`

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: `FactureDto`

#### GET `/api/factures/{id}`

Retrieve a single facture by ID.

- **Path Parameters:**
    - `id` (integer, required): Facture ID

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: `FactureDto`

#### PUT `/api/factures/{id}`

Update an existing facture by ID.

- **Path Parameters:**
    - `id` (integer, required): Facture ID

- **Request Body:**
    - Content Type: `application/json`
    - Schema: `FactureAdd`

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: `FactureDto`

#### DELETE `/api/factures/{id}`

Delete a facture by ID.

- **Path Parameters:**
    - `id` (integer, required): Facture ID

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: Boolean

---

### Depenses

#### GET `/api/depenses`

Retrieve all depenses.

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: Array of `DepenseDto`

#### POST `/api/depenses`

Create a new depense.

- **Request Body:**
    - Content Type: `application/json`
    - Schema: `DepenseAdd`

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: `DepenseDto`

#### GET `/api/depenses/{id}`

Retrieve a single depense by ID.

- **Path Parameters:**
    - `id` (integer, required): Depense ID

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: `DepenseDto`

#### PUT `/api/depenses/{id}`

Update an existing depense by ID.

- **Path Parameters:**
    - `id` (integer, required): Depense ID

- **Request Body:**
    - Content Type: `application/json`
    - Schema: `DepenseAdd`

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: `DepenseDto`

#### DELETE `/api/depenses/{id}`

Delete a depense by ID.

- **Path Parameters:**
    - `id` (integer, required): Depense ID

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: Boolean

---

### Categories

#### GET `/api/categories`

Retrieve all categories.

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: Array of `CategorieFactureDto`

#### POST `/api/categories`

Create a new category.

- **Request Body:**
    - Content Type: `application/json`
    - Schema: `CategorieFactureAdd`

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: `CategorieFactureDto`

#### GET `/api/categories/{id}`

Retrieve a single category by ID.

- **Path Parameters:**
    - `id` (integer, required): Category ID

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: `CategorieFactureDto`

#### PUT `/api/categories/{id}`

Update an existing category by ID.

- **Path Parameters:**
    - `id` (integer, required): Category ID

- **Request Body:**
    - Content Type: `application/json`
    - Schema: `CategorieFactureAdd`

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: `CategorieFactureDto`

#### DELETE `/api/categories/{id}`

Delete a category by ID.

- **Path Parameters:**
    - `id` (integer, required): Category ID

- **Response:**
    - Status: `200 OK`
    - Content Type: `*/*`
    - Response Body: Boolean

---

### User Authentication

#### GET `/api/user/getUser`

Retrieve the authenticated user's data.

- **Header Parameters:**
    - `Authorization` (string, required): Bearer token

- **Response:**
    - Status: `200 OK`
    - Content Type: `application/json`
    - Response Body: User object

#### POST `/api/auth`

Authenticate a user (login).

- **Request Body:**
    - Content Type: `application/json`
    - Schema: `LoginDto`

- **Response:**
    - Status: `200 OK`
    - Content Type: `application/json`
    - Response Body: `AuthDto`

#### POST `/api/auth/logout`

Log out a user.

- **Request Body:**
    - Content Type: `application/json`
    - Schema: `RefreshTokenRequest`

- **Response:**
    - Status: `200 OK`
    - Content Type: `application/json`
    - Response Body: Empty object

#### POST `/api/auth/refresh`

Refresh the access token.

- **Request Body:**
    - Content Type: `application/json`
    - Schema: `RefreshTokenRequest`

- **Response:**
    - Status: `200 OK`
    - Content Type: `application/json`
    - Response Body: Empty object

#### POST `/api/auth/register`

Register a new user.

- **Response:**
    - Status: `200 OK`
    - Content Type: `application/json`
    - Response Body: `AuthDto`

