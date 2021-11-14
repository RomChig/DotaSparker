import {MatchDetail} from "../model/MatchDetail";
import {Table} from "react-bootstrap";

export const MatchDetailPage = ({match}) => {
    console.log(match)
    return <Table striped bordered hover variant="dark" className='text-center'>
        <thead>
        <tr>
            <th>Id</th>
            <th>Game Mode</th>
            <th>Side</th>
            <th>Duration</th>
            <th>Players</th>
        </tr>
        </thead>
        <MatchDetail match={match}/>
    </Table>
}