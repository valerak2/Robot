package serialization

import serialization.state.OptionState
import serialization.state.RobotCustomize
import serialization.state.WindowState

import java.awt.Color

Map<String, Record> data = new HashMap<>()
String path = System.getProperty("user.home") + File.separator + "window_and_robot_states"
File file = new File(path)
if (file.exists()) {
    List<String> text = file.getText().split("(\n)")
    for (line in text) {
        switch (line[0][0]) {
            case 'g':
                window("gameWindow", line)
                break
            case 'l':
                window("logWindow", line)
                break
            case 's':
                window("statisticsWindow", line)
                break
            case 'o':
                options(line)
                break
            case 'c':
                customize(line)
                break
            case 'p':
                println(line.findAll("([0-9]+)"))
                break
        }
    }

}


private Record window(String name, String line) {
    List prm = line.findAll("([0-9]+)|(false)|(true)")
    WindowState window = new WindowState(
            prm[0] as int,
            prm[1] as int,
            prm[2] as int,
            prm[3] as int,
            prm[5] as boolean)
    println(window)
    data.put(name, window)
}

private Record options(String line) {
    Record option = new OptionState(line.findAll("(eng)|(ru)").get(0), "")
    println(option)
    data.put("options", option)
}

private Record customize(String line) {
    List prm = line.findAll("([0-9]+)|(Oval)|(Rect)")
    Record customize = new RobotCustomize(new Color(
            prm[0] as int,
            prm[1] as int,
            prm[2] as int),
            prm[3] as String)
    data.put("customize", customize)
}
data