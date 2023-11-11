import axios from 'axios';

//Used to make HTTP requests to the relevent remote API

//header information for cross origin resource sharing (CORS)
export default axios.create({
    baseURL:'http://localhost:8080',
    headers:{"skip-browser-warning": "true"}
});