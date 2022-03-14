import axios from "axios"

class Controller {
    static async getData() {
        const data = await axios.get("http://localhost:8080/gamedata")
        return data
    }

    // getInput (ตอนนี้ยังไม่ได้รับค่าอะไรจากfrontend)
    // static async getAllInput() {
    //     const resp = await axios.get<number>('http://localhost:8080/input')
    //     return resp.data
    // }
}
