package serialization

class WriteData {
    WriteData(String path, Map data) {
        FileWriter file = new FileWriter(path)
        for (String key in data) {
            file.write(key + "\n")
        }
        file.close()
    }
}
