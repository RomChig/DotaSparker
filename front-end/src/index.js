import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import {Provider} from "react-redux";
import {createStore} from "redux";
import {loadFromLocalStorage, saveToLocalStorage} from "./service";
import {HEROES} from "./util";

export const setHeroesToState = (heroes = {}) => {
    return {
        type: "LOAD_HEROES",
        heroes
    };
}

export const main_page = (current_state = {}, action = {}) => {
    switch (action.type) {
        case "LOAD_HEROES":
            return action.heroes;
        default:
            return current_state;
    }
}

const store = createStore(main_page, loadFromLocalStorage(HEROES));

store.subscribe(() => saveToLocalStorage(store.getState(), HEROES));

ReactDOM.render(
    <React.StrictMode>
        <Provider store={store}>
            <App/>
        </Provider>
    </React.StrictMode>,
    document.getElementById('root')
);
