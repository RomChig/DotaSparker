import {useEffect, useState} from "react";
import {getAmountPlayerMatches} from "../service/PlayerService";
import {MatchesFilter, EntityPagination, MatchTable} from "../component";
import {calculateCurrentEntitiesViaPagePagination, STEAM_ID} from "../util";
import {useHistory} from "react-router-dom";


export const AllMatchesPage = () => {
    const initialMatchNumbers = 7;
    const [matches, setMatches] = useState([]);
    const [matchNumbers, setMatchNumbers] = useState(initialMatchNumbers);
    const [currentPage, setCurrentPage] = useState(1);
    const [matchPerPage] = useState(initialMatchNumbers);

    const history = useHistory()
    const loadMatches = () => {
        getAmountPlayerMatches(STEAM_ID, matchNumbers).then(data => setMatches(data));
    }

    useEffect(() => loadMatches(), []);

    const handleNumbers = numbers => {
        !numbers || numbers === '0'
            ? setMatchNumbers(initialMatchNumbers)
            : setMatchNumbers(Math.abs(numbers));
    }
    const handleClick = matchId => {
        history.push('/matchDetail', matchId);
    }


    const handleSubmit = () => loadMatches();
    const currentMatches = calculateCurrentEntitiesViaPagePagination(matches, currentPage);
    const paginate = pageNumber => setCurrentPage(pageNumber);
    return (
        !currentMatches ? ''
            : <div>
                <MatchesFilter setMatchNumbers={handleNumbers} onSubmit={handleSubmit}/>
                <MatchTable matches={currentMatches} onClick={handleClick}/>
                <EntityPagination entityPerPage={matchPerPage}
                                  totalEntities={matches.length}
                                  paginate={paginate}/>
            </div>
    )
}
