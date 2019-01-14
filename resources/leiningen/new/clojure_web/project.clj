(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 ;;; core
                 [ring "1.7.1"]
                 [compojure "1.6.1"]
                 ;;; environment
                 [environ "1.1.0"]
                 ;;; database
                 [com.layerware/hugsql "0.4.9"]
                 [org.postgresql/postgresql "42.2.5"]
                 [migratus "1.2.0"]
                 ;;; logging
                 [com.taoensso/timbre "4.10.0"]
                 [raven-clj "1.5.2"] ; timbre sentry support
                 ;;; security
                 [buddy "2.0.0"]
                 ;;; ui
                 [hiccup "1.0.5"]
                 [garden "1.3.6"]
                 ;;; middleware
                 [ring/ring-defaults "0.3.2"]
                 ;;; hosted assests
                 [ring-webjars "0.2.0"]
                 [org.webjars/font-awesome "5.6.3"]]


  :plugins [[lein-environ "1.1.0"]
            [lein-ring "0.12.4"]
            [migratus-lein "0.7.0"]
            [lein-garden "0.3.0"]
            [lein-pdo "0.1.1"]]


  :ring {:handler {{name}}.core/app
         :port 8000}


  :garden {:builds [{:source-paths ["src"]
                     :id           "style"
                     :stylesheet   {{name}}.css/style
                     :compiler     {:output-to     "resources/public/css/style.css"
                                    :pretty-print? true}}]}


  :clean-targets ^{:protect false} ["resources/public/css"]


  :migratus {:store :database
             :migration-dir "migrations"
             :db ~(get (System/getenv) "DATABASE_URL")}


  :profiles {:uberjar {:aot :all}
             :dev {
                   :main {{name}}.core/-dev-main
                   :dependencies [[javax.servlet/servlet-api "2.5"] ; do i need?
                                  [ring/ring-mock "0.3.2"]]}
             :test {:dependencies[[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.2"]]}}


  :main {{name}}.core


  :uberjar-name "{{name}}.jar"


  :prep-tasks ["clean" ["garden" "once"] "compile"]


  :aliases {"dev" ["pdo" ["garden" "auto"] ["ring" "server"]]}


  )
