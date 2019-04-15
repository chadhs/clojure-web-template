{:profiles/dev
 {:env
  {:database-url "jdbc:postgresql://localhost/{{name}}-dev"
   :reported-log-level "debug"
   :session-cookie-key "changecookiekey1"}}
 :profiles/test
 {:env
  {:database-url "jdbc:postgresql://localhost/{{name}}-test"
   :reported-log-level "debug"
   :session-cookie-key "changecookiekey2"}}}
