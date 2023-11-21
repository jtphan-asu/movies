import {useEffect, useRef} from 'react';
import api from '../../api/axiosConfig';
import {useParams} from 'react-router-dom';
import {Container, Row, Col} from 'react-bootstrap';
import ReviewForm from '../reviewForm/ReviewForm';

const Reviews = ({getMovieData, movie,reviews, setReviews }) => {

    //use useRef from ReviewForm.js to extract information from URL
    const revText = useRef();
    let params = useParams();
    const movieId = params.movieId;

    useEffect(() => {
        getMovieData(movieId);
    },[])

    //Method to add a Review using HTTP Post request functionality
     const addReview = async (e) =>{
            e.preventDefault();

            const rev = revText.current;

            try
            {
                const response = await api.post("/api/v1/reviews",{reviewBody:rev.value,imdbId:movieId});

                //Update state of the array on the client side
                const updatedReviews = [...reviews, {body:rev.value}];

                //Clear relevant text after the user has submitted the review
                rev.value = "";

                //Update array directly from data entered on the client
                setReviews(updatedReviews);
            }
            catch(err)
            {
                console.error(err);
            }
        }

    return (
        <Container>
            <Row>
                <Col><h3>Reviews</h3></Col>
            </Row>
            <Row className="mt-2">
                <Col>
                    <img src={movie?.poster} alt=""/>
                </Col>
                <Col>
                    {
                        <>
                            <Row>
                                <Col>
                                    <ReviewForm handleSubmit={addReview} revText={revText} labelText="Write a Review?"></>
                                </Col>
                            </Row>
                            <Row>
                                <Col>
                                    <hr />
                                </Col>
                            </Row>
                        </>
                    }
                    {
                        reviews?.map((r) => {
                           return(
                               <>
                                   <Row>
                                       <Col>{r.body}</Col>
                                   </Row>
                                   <Row>
                                       <Col>
                                           <hr />
                                       </Col>
                                   </Row>
                               </>
                           )
                       })
                    }
                </Col>
            </Row>
            <Row>
                <Col>
                    <hr />
                </Col>
            </Row>
        </Container>


    )

}

export default Reviews