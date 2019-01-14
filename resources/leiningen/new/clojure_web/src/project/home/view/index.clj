(ns {{name}}.home.view.index
  (:require [{{name}}.home.view.layout :as home.view.layout])
  (:require [hiccup.core :refer [html]]))


(defn home-page []
  (home.view.layout/page-layout
   (html
    [:div#tagline
     "coming soon..."]

    [:p.content
     "FIXME"]
    )))
