def read_file(
    file_path: str, expected_text: str = None, interactive: bool = True
) -> str:
    try:
        with open(file_path, "r", encoding="utf-8") as f:
            content = f.read()

        if expected_text is not None:
            if content != expected_text:
                if interactive:
                    choice = input(
                        "Текст таарахгүй байна. Текстийг replace хийж бичих үү? (y/n): "
                    )
                    if choice.strip().lower() == "y":
                        try:
                            with open(file_path, "w", encoding="utf-8") as wf:
                                wf.write(expected_text)
                            return expected_text
                        except PermissionError:
                            return "Алдаа: Файл бичих эрхгүй!"
        return content

    except FileNotFoundError:
        return "Алдаа: Файл олдсонгүй!"
    except Exception as e:
        return f"Алдаа: {str(e)}"
