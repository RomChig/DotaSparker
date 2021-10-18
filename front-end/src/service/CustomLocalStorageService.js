// convert object to string and store in localStorage
export const saveToLocalStorage = (data, itemKey) => {
    try {
        const serialisedState = JSON.stringify(data);
        localStorage.setItem(itemKey, serialisedState);
    } catch (e) {
        //TODO: there's only console warning for now
        console.warn('Couldn\'t save data to local storage', e);
    }
}

// load string from localStarage and convert into an Object
// invalid output must be undefined
export const loadFromLocalStorage = itemKey => {
    try {
        const serialisedState = localStorage.getItem(itemKey);
        if (serialisedState === null) return undefined;
        return JSON.parse(serialisedState);
    } catch (e) {
        //TODO: there's only console warning for now
        console.warn('Couldn\'t get data from local storage', e);
        return undefined;
    }
}

export const isEmptyStorage = object => Object.keys(object).length === 0;