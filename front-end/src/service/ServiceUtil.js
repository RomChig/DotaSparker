import {ID, SLASH} from "../util";

export const replaceIdInTheString = (string, id) => string.replace(ID, SLASH.concat(id));

export const axiosHandler = axiosRequest => {
    return axiosRequest.then(res => res.data)
        //TODO - temporary only logging exception
        .catch(error => console.log(error));
}