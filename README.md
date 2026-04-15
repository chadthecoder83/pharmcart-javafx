# pharmcart-javafx# PharmCart

PharmCart is a JavaFX desktop pharmacy e-commerce application created for CST 338. The application allows users to browse pharmacy products and allows administrators to manage inventory. The project uses a SQLite database for persistence and follows a team-based GitHub workflow with issues, feature branches, pull requests, and tests.

## Team Members
- Chadwick Smith
- Elizabeth Leon

## Project Description
PharmCart is designed as a pharmacy store application with two main roles:

### Regular Users
- Log in
- View available products
- Browse pharmacy inventory
- Place orders

### Administrators
- Add new products
- Update product information
- Delete products
- Manage inventory

## Technologies Used
- Java
- JavaFX
- SQLite
- JDBC
- Gradle
- JUnit

## Features Completed So Far
- SQLite database connection
- Database schema with `users`, `products`, and `orders` tables
- CRUD operations for products
- JavaFX login screen
- JavaFX product screen
- Scene navigation with `SceneManager`
- JUnit database test
- Basic UI test
- GitHub issue / branch / pull request workflow

## Database Tables
The application currently uses these tables:

- **Users**
  - `user_id`
  - `username`
  - `password`
  - `role`

- **Products**
  - `product_id`
  - `name`
  - `category`
  - `price`
  - `quantity_in_stock`

- **Orders**
  - `order_id`
  - `user_id`
  - `product_id`
  - `quantity`
  - `total_price`
  - `status`
  - `created_at`

## Current Use Cases
- User logs in
- User views product list
- User places an order
- Admin adds a product
- Admin updates a product
- Admin deletes a product

## GitHub Workflow
This project uses the required team workflow:
- Public GitHub repository
- Feature branches using the format `yourname/feature-name`
- GitHub Issues for task tracking
- Pull Requests for all merges into `main`
- Teammate review before merge

## Mockups / Screens

### Login Screen

<img width="769" height="490" alt="Screenshot 2026-04-14 at 6 06 33 PM" src="https://github.com/user-attachments/assets/9a5c82a0-35a8-41ff-8e1b-2e48ad3648b2" />

### Product Screen
<img width="497" height="266" alt="Screenshot 2026-04-14 at 6 08 13 PM" src="https://github.com/user-attachments/assets/ef568c3b-adc6-48ba-924c-2af01415e05d" />


### Admin Screen

<img width="543" height="347" alt="Screenshot 2026-04-14 at 6 09 25 PM" src="https://github.com/user-attachments/assets/33f3c83b-eec3-4b80-a9e6-006de22ed864" />


## Testing
Testing is done with JUnit and includes:
- Database connection testing
- Product CRUD testing
- Basic UI-related testing

## Repository Link
[PharmCart Repository](https://github.com/SP26-cst338-ol/lab-javafx-ftoc-chadthecoder83)
