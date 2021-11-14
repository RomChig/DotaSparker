import {getAllHeroes} from "./HeroService";
import {setHeroesToState} from "../index";
import {isEmptyStorage} from './'

export const loadHeroes = (heroes, dispatch) => {
    if (!heroes || isEmptyStorage(heroes)) {
        getAllHeroes().then(heroes => {
            dispatch(setHeroesToState(heroes))
        });
    }
}