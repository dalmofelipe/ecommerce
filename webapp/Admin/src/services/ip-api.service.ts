class IpApiService {

    private BASE_URL = "http://ip-api.com/json?fields=status,message,countryCode,region,city,lat,lon,timezone,query&lang=pt-BR"
    
    async getLocation() {
        return await fetch(this.BASE_URL)
            .then(response => response.json())
            .catch(error => console.error(error));
    }

}


export default IpApiService