
const BASE_URL = process.env.REACT_APP_ECOMMERCE_API_URL as string

async function getAllCategories() {
    return await fetch(BASE_URL + "/categories")
        .then(response => response.json())
        .catch(error => console.error(error));
}

export {
    getAllCategories
}