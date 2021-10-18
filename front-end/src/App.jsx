import {Container} from "react-bootstrap";
import {loadFromLocalStorage, loadHeroes} from "./service";
import {useDispatch} from "react-redux";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import {Header, HeroesPage, AllMatchesPage} from "./component";
import {HEROES, PATH_TO_MAIN_PAGE, PATH_TO_MATCHES_PAGE} from "./util";
import {MatchDetailPage} from "./page/MatchDetailPage";
import {getMatchById} from "./service";
import {useEffect, useState} from "react";

const App = () => {
    const dispatch = useDispatch();
    //TODO: information ob the match shouldn't be at this layer
    let [currentMatch, setCurrentMatch] = useState();
    let [currentMatchId, setCurrentMatchId] = useState();
    const handleMatchDetail = (matchId) => {
        setCurrentMatchId(matchId);
    }

    useEffect(() => {
        //TODO: loading a match should be moved in another place
        if (currentMatchId) {
            getMatchById(currentMatchId).then(match => setCurrentMatch(match));
        }
    }, [currentMatchId])

    return (
        <Router>
            <Container>
                <Header/>
                <Switch>
                    <Route exact path={PATH_TO_MAIN_PAGE} render={() => {
                        let heroes = loadFromLocalStorage(HEROES);
                        loadHeroes(heroes, dispatch);
                        return heroes ? <HeroesPage heroes={heroes}/> : ''
                    }}/>
                    <Route exact path={PATH_TO_MATCHES_PAGE} render={() => <AllMatchesPage/>}/>
                    <Route exact path={'/matchDetail'}
                           render={(props) => {
                               handleMatchDetail(props.location.state);
                               return currentMatch ? <MatchDetailPage match={currentMatch}/> : ''
                           }}/>
                </Switch>
            </Container>
        </Router>)

}

export default App;
