# _e-vignette_

## Order - Microservice

When a user logs into the system, they can begin ordering a vignette. It accomplishes this by typing the license plate twice, which reduces the occurrence of errors and necessitates double-checking the field. This is followed by selecting a vignette type, in which the user selects which vignette they want to purchase. After all, the user has the option of executing a transaction, which submits the purchase in the database and tells the user of its success.
  
| Functional requirements | Non-functional requirements |
|:-------------|:-------------|
| Order execution status  | The order is executed in less than 30 s |
| Enter the registration number  | The registration plate must be entered twice to reduce errors. |
| Selecting the type of e-vignette  | The user has the option of choosing between (weekly, monthly, annual, semi-annual) |
  
## Diagram

![DDD-Order](https://user-images.githubusercontent.com/56564308/158081327-4ede154f-279e-47c5-8cb6-26aa93dd5b95.jpg)
