(ns {{name}}.home.handler
  (:require [{{name}}.home.view.index :as home.view.index]))


(defn handle-home-index [req]
  (home.view.index/home-page))
