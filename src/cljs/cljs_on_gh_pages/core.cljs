(ns cljs-on-gh-pages.core
  (:require [reagent.core :as reagent]
            [cljs-on-gh-pages.markdown :as m]))

(enable-console-print!)

(defonce app-state (reagent/atom {:text "Sndrea"}))

(defn blog-post
  []
  (m/md->reagent
   "## <a name=\"why-would-you\" href=\"#why-would-you\">Why would you want that?</a>

    **Writing** a blog post _with_ "))

(defn page
  []
  [:div [blog-post]])

(defn ^:export main []
  (reagent/render [page]
                  (.getElementById js/document "cljs-on-gh-pages")))
