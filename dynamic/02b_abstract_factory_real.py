class FileReader(object):
    def __new__(self, path, *args, **kwargs):
        if path.startswith('/'):
            return LocalFileReader(path)
        elif path.startswith('ssh:'):
            return RemoteFileReader(path)
        raise Exception(
            "No valid file reader for given connection string: {0}".format(
                path
            )
        )


class LocalFileReader(object):
    def __init__(self, path):
        self.path = path

    def read_lines(self):
        with open(self.path, 'r') as f:
            return "\n".join(f.readlines())


class RemoteFileReader(object):
    def __init__(self, path):
        self.path = path

    def read_lines(self):
        return "did something in the network supposedly"


local_file_reader = FileReader(
    '/Users/contentdave/dev/PatternDemos/SomeText.txt'
)
print(local_file_reader.read_lines())

print()

remote_file_reader = FileReader('ssh://user@pass:foo.bar.com/something.txt')
print(remote_file_reader.read_lines())

print()

try:
    FileReader('unknown connection string')
except Exception as e:
    print(e)
