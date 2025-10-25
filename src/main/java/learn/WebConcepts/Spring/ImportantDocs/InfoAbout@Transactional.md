## @Transactional
* ahedihewerwje.
    ## How Transaction works in database level and Why transaction need be maintained?
    * **SQL** uses transactions to follow ACID properties 
        * A -> Atomicity
        * C -> Consistency
        * I -> Isolation
        * D -> Durability
    * **Atomicity**:
        * suppose in 100 transactions any transaction fails, 100 transactions should **ROLL BACK** call it as **Atomicity**.
    * **Consistency**:
        * Suppose 100 transactions performing individually by **commiting(Saving completely in database)** each transaction.
        * Here 100th transaction is depending on 1st transaction like, 1st transaction debiting some amount, 100th transaction should credit that amount in between these two transaction there is a time difference will be there which makes inconsistency in data, since 1st transaction completely saved debit data in DB without saving 100th transaction credit data in DB.
        * This issue can be resolved by committing all transactions at once.
