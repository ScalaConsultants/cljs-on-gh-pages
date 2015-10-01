(ns cljs-on-gh-pages.markdown
  "A small utility to render markdown to react/reagent componet. Taken
  from Devcards, thank you Bruce Hauman."
  (:require [cljs-on-gh-pages.impl.markdown :as impl]))

(defn md->react
  "Interprets the input string(s) as markdown, yielding a react
  component. It logs a message and creates an error :div in case of
  failure."
  [& strs]
  (if (every? string? strs)
    (let [blocks (mapcat impl/parse-out-blocks strs)]
      [:div.markdown-block
       (map impl/markdown-block->react blocks)])
    (let [message "Error: The input should be a seq of strings containing less-sensitive-markdown."]
      (try (.error js/console message))
      [:div {:style {:color "#a94442"}} message])))

(defn md->reagent
  "Interprets the input string(s) as markdown, yielding a reagent
  component. It logs a message and creates an error :div in case of
  failure."
  [& strs]
  (apply md->react strs))
