(ns {{name}}.route
  (:require [{{name}}.home.route   :as home.route]
            [{{name}}.home.handler :as home.handler])
  (:require [compojure.core  :refer [defroutes ANY GET POST PUT DELETE]]
            [compojure.core  :as    compojure]
            [compojure.route :as    route]))


(defroutes core-routes
  (GET             "/" [] home.handler/handle-home-index)
  (route/not-found        "Page not found."))


(def combined-routes
  ;; core-routes last so the not-found call is the last matching route
  (compojure/routes
   home.route/home-routes
   core-routes))
