var CloneIndex = 0;
       function OnLoad() {
              var HT = new HtHottourAffiliate('6cfd2ae6d87844e58a10962127b3d226');
                  HT.TemplateMethod = "GET";
                  HT.TemplateUrl = "HotSmallTemplate.html";<!-- указываем ссылку на маленькую форму, заметим что этот файл находиться на том же сервере в том же каталоге что и текущий проект-->

           HT.onCloneRow = function(row, data) {
                         var link = row.find('[tname="ResultSet.Link"]');

              link.attr("href", "http://hottour.by/where_to_buy.aspx?type=sptour&sid=" + data.ID + "&UID=" + HtHottourInstance._uid);
              var link2 = row.find('[tnameprocessed="ResultSet.HotelName"]');
              link2.attr("href", data.HotelLink);

                         CloneIndex++;
              if (CloneIndex % 2 == 0) {
                  row.attr("bgcolor", "#f2f2f2");
              }
          };

           HT.CreateTable('#HottourSearchPlace');
       };

          $(document).ready(OnLoad);