(ns cljs-on-gh-pages.core
  (:require [reagent.core :as reagent]
            [cljs-on-gh-pages.markdown :as m]))

(enable-console-print!)

(defn page
  []
  [:div.console-container
   [:div#console.console]])

(defn ^:export main []
  (reagent/render [page]
                  (.getElementById js/document "cljs-on-gh-pages")))
