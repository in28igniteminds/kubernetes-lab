### Microservices

These simple microservices enable us to **focus on** learning the tools - Docker, Kubernetes, CI, CD and  build the infrastructure needed around typical microservices.

### Bank Interest Service

If you ask it the interest rate of SBI and ICICI, the service returns the answers.
If you ask the rates simply, it returns the interest rate for all banks
- Interest rate of SBI is 10%
- Interest rate of ICICI is 20%

http://localhost:8000/rates/SBI/

```json
{
  "id": 10002,
  "bankName": "SBI",
  "interestRate": "10",
}
```

### FD Returns Calculator Service

FD Returns calculator service is used to calculate the fixed deposit return rates for various banks. If you want to know, if you invest 1000 EUR in SBI after one year what will be the return will be returned by this service
- **STEP 1** : FD Returns calculator service calls the bank interest service to know what is the interest rate for the given bank
- **STEP 2** : Then it multiplies the input amount with the interest rate and gives the returns for a year

http://localhost:8100/api/v1/fdreturns/from/SBI/for/10000

```json

```

#### How does FD Returns calculator service know the location of Bank Interest?
- You don't want to HARDCODE
- Configure an Environment Variable - `BANK_INTEREST_SERVICE_HOST`
- --env BANK_INTEREST_SERVICE_HOST=http://bank-interest