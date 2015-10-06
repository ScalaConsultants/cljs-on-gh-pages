(defproject cljs-on-gh-pages "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"]
                 [reagent "0.5.1"]
                 [cljsjs/showdown "0.4.0-1"]]
  :source-paths ["src/clj"]
  :plugins [[lein-cljsbuild "1.1.0"]
            [lein-figwheel "0.4.0" :exclusions [cider/cider-nrepl]]  ]
  :clean-targets ^{:protect false} ["../../scripts/cljs-on-gh-pages/js/compiled" "resources/public/cljs-on-gh-pages/js/compiled" "target"  ]

  :cljsbuild  {:builds [{:source-paths ["src/cljs"]
                         :figwheel {:on-jsload "cljs-on-gh-pages.core/main"
                                    :open-file-command "emacsclient"
                                    :css-dirs ["resources/public/styles"]}
                         :compiler {:main cljs-on-gh-pages.core
                                    :output-to "resources/public/cljs-on-gh-pages/js/compiled/cljs-on-gh-pages.js"
                                    :output-dir "resources/public/cljs-on-gh-pages/js/compiled/out"
                                    :asset-path "cljs-on-gh-pages/js/compiled/out"
                                    :source-map-timestamp true}}
                        {:id "jekyll-dev"
                         :source-paths ["src/cljs"]
                         :devcards true
                         :figwheel {:on-jsload "cljs-on-gh-pages.core/main"}
                         :compiler {:main cljs-on-gh-pages.core
                                    :output-to "../../scripts/cljs-on-gh-pages/js/compiled/cljs-on-gh-pages.js"
                                    :output-dir "../../scripts/cljs-on-gh-pages/js/compiled/out"
                                    :asset-path "/scripts/cljs-on-gh-pages/js/compiled/out"
                                    :source-map-timestamp true}}
                        {:id "jekyll"
                         :source-paths ["src/cljs"]
                         :compiler {:main cljs-on-gh-pages.core
                                    :output-to "../../scripts/cljs-on-gh-pages/js/compiled/cljs-on-gh-pages.js"
                                    :optimizations :advanced
                                    :pretty-print false}}]})
