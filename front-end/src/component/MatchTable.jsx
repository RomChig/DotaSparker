import {Match} from "../model";
import {Table} from "react-bootstrap";


export const MatchTable = ({matches, onClick = f => f}) => {
    return (
        <Table striped bordered hover variant="dark" className='text-center'>
            <thead>
            <tr>
                <th>id</th>
                <th>Date</th>
                <th>Heroes</th>
            </tr>
            </thead>
            {
                matches.map((match, index) => <Match key={index} match={match} onClick={onClick}/>)
            }
        </Table>
    )
}