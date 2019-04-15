(ns leiningen.new.clojure-web
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))


(def render (renderer "clojure-web"))


(defn clojure-web
  "generate new clojure web project from template files"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' clojure-web project.")
    (->files data
             ["Procfile"                               (render "Procfile" data)]
             ["README.md"                              (render "README.md" data)]
             ["design.md"                              (render "design.md" data)]
             [".gitignore"                             (render "gitignore" data)]
             ["profiles_example.clj"                   (render "profiles_example.clj" data)]
             ["project.clj"                            (render "project.clj" data)]
             ["test/{{sanitized}}/core_test.clj"       (render "test/project/core_test.clj" data)]
             ["src/{{sanitized}}/core.clj"             (render "src/project/core.clj" data)]
             ["src/{{sanitized}}/config.clj"           (render "src/project/config.clj" data)]
             ["src/{{sanitized}}/css.clj"              (render "src/project/css.clj" data)]
             ["src/{{sanitized}}/route.clj"            (render "src/project/route.clj" data)]
             ["src/{{sanitized}}/util/core.clj"        (render "src/project/util/core.clj" data)]
             ["src/{{sanitized}}/home/handler.clj"     (render "src/project/home/handler.clj" data)]
             ["src/{{sanitized}}/home/route.clj"       (render "src/project/home/route.clj" data)]
             ["src/{{sanitized}}/home/view/index.clj"  (render "src/project/home/view/index.clj" data)]
             ["src/{{sanitized}}/home/view/layout.clj" (render "src/project/home/view/layout.clj" data)])))
