# design

## data

FIXME

```clojure
(def table1
  {
   :id       :uuid
   :email    :varchar64
   :password :varchar128
   :date_created :timestamptz
   }
  )

(def table2
  {
   :id           :uuid
   :account_id   :uuid
   :service_id   :varchar64
   :is_member    :boolean
   :date_created :timestamptz
   }
  )
```
