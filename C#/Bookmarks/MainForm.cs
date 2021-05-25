using Bookmarks.Components;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Windows.Forms;

namespace Bookmarks {

    public partial class MainForm : Form {
        private const string JSON_FILEPATH = "./data.json";

        public MainForm()
            => InitializeComponent();

        private void OnAddClick(object sender, EventArgs e)
            => new BookmarkSetup().ShowDialog(this);

        public bool TryAdd(Bookmark bookmark)
            => listBookmarks.TryAdd(bookmark);

        public void Remove(Bookmark bookmark)
            => listBookmarks.Remove(bookmark);

        private void SaveJson(object sender, FormClosingEventArgs e) {
            var ser = listBookmarks.Controls[0].Controls;
            List<BookmarkData> data = new();
            foreach(Control ctrl in ser) {
                if(ctrl is Bookmark bookmark)
                    data.Add(bookmark.Data);
            }
            string json = JsonConvert.SerializeObject(data);
            File.WriteAllText(JSON_FILEPATH, json);
        }

        private void LoadJson(object sender, EventArgs e) {
            if(!File.Exists(JSON_FILEPATH))
                return;

            string json = File.ReadAllText(JSON_FILEPATH);
            List<BookmarkData> data = JsonConvert.DeserializeObject<List<BookmarkData>>(json);
            foreach(BookmarkData bookmark in data) {
                bookmark.AsControl = new Bookmark(bookmark);
                listBookmarks.Append(bookmark.AsControl);
            }
        }
    }

}
